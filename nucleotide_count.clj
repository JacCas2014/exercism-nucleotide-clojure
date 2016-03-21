 (ns nucleotide-count)

 (defn count
   [nucleotide dna]
   (let [frequencies-of-nucleotides (frequencies dna)]
     (if (not-empty frequencies-of-nucleotides)
       (frequencies-of-nucleotides nucleotide)
       0)))

 (defn nucleotide-counts
   [dna]
   {\A 0, \T 0, \C 0, \G 0})