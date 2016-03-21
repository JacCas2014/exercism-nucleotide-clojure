 (ns nucleotide-count)

 (defn count
   [nucleotide dna]
   (let [number-of-nucleotide ((frequencies dna) nucleotide)]
      (if (nil? number-of-nucleotide)
        0
        number-of-nucleotide)))

 (defn nucleotide-counts
   [dna]
   {\A (count \A dna) , \T (count \T dna), \C (count \C dna), \G (count \G dna)})