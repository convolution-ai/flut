package com.convolutionai.etl

import com.convolutionai.flut.core.{Extractor, Loader, Transformer}
import com.convolutionai.flut.etl.SimpleEtl

import scala.util.Random
import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec


class SimpleEtlTest extends AnyFlatSpec with Matchers{


  "createSimpleEtl" should "return SimpleEtl outExample" in {

    type InputExample = Seq[Int]
    type OutExample = Seq[String]
    val inputExample = Seq.fill(10)(Random.nextInt)

    object Extractor extends Extractor[InputExample] {
      override def extract(): InputExample = inputExample
    }

    object  Transformer extends Transformer[InputExample, OutExample] {
      override def transform(t: InputExample): OutExample = t.map(_.toString)
    }

    object  Loader extends Loader[Seq[String]] {
      override def load(t: OutExample): OutExample = t
    }

    SimpleEtl[InputExample, OutExample](Extractor, Transformer, Loader).execute() shouldBe inputExample.map(_.toString)
  }

}