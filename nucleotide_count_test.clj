(ns nucleotide-count-test
  (:require [nucleotide-count :refer [count nucleotide-counts]])
  (:use midje.sweet))

(fact "empty-dna-strand-has-no-adenosine"
             (nucleotide-count/count \A "") => 0)

(fact "empty-dna-strand-has-no-nucleotides"
             (nucleotide-count/nucleotide-counts "") => {\A 0, \T 0, \C 0, \G 0})

(fact "repetitive-cytidine-gets-counted"
             (nucleotide-count/count \C "CCCCC") => 5)

(future-fact "repetitive-sequence-has-only-guanosine"
             (nucleotide-count/nucleotide-counts "GGGGGGGG") => {\A 0, \T 0, \C 0, \G 8})

(future-fact "counts-only-thymidine"
             (nucleotide-count/count \T "GGGGGTAACCCGG") => 1)

(future-fact "validates-nucleotides"
             (nucleotide-count/count \X "GACT") => (throws Throwable))

(future-fact "counts-all-nucleotides"
      (let [s "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"]
        (nucleotide-count/nucleotide-counts s) => {\A 20, \T 21, \G 17, \C 12}))
