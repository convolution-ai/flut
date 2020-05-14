package com.convolutionai.flut.core

trait Extractor[T] {
  def extract(): T
}

trait Transformer[T, S] {
  def transform(t : T): S
}

trait Loader[S] {
  def load(t: S): S

}

sealed trait EtlDefinition[A, B] {

  val e: Extractor[A]
  val t: Transformer[A, B]
  val l: Loader[B]
  def extract()(e: Extractor[A] = e): A
  def transform(a: A)(t: Transformer[A, B] = t): B
  def load(b: B)(l: Loader[B] = l): B

}


abstract class Etl[X, Y](e: Extractor[X], t: Transformer[X, Y], l: Loader[Y]) extends EtlDefinition[X, Y] {

  override def extract()(e: Extractor[X] = e): X = e.extract()

  override def transform(a: X)(t: Transformer[X, Y]): Y = t.transform(a)

  override def load(b: Y)(l: Loader[Y]): Y = l.load(b)

  def execute(): Y = load(transform(extract()())())()
}

