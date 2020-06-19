package com.convolutionai.flut.etl
import com.convolutionai.flut.core.{Etl, Extractor, Loader, Transformer}

case class SimpleEtl[X, Y](override val e: Extractor[X], override val t: Transformer[X, Y],
                           override val l: Loader[Y]) extends Etl(e, t, l)
