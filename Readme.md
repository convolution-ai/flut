# Flut

Small and simple scala library for build ETLs.

![alt text](flut.jpg)


### Add build SBT
```scala
libraryDependencies += "com.convolution-ai" % "flut" % "0.1.0"
```

### Example

```scala

    type InputExample = Seq[Int]
    type OutExample = Seq[String]

    object Extractor extends Extractor[InputExample] {
      override def extract(): InputExample = inputExample
    }

    object  Transformer extends Transformer[InputExample, OutExample] {
      override def transform(t: InputExample): OutExample = t.map(_.toString)
    }

    object  Loader extends Loader[Seq[String]] {
      override def load(t: OutExample): OutExample = t
    }
    
    SimpleEtl[InputExample, OutExample](Extractor, Transformer, Loader).execute()
 
 ```
