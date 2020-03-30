# DNA-Cypher
Simple text encoding-decoding application, based on mRNA translation process.


**Technology stack:**
Java 11, JUnit 5.6.0, Maven 3.6.2


**How it works?**

Program uses codons - triplets of random four "nucleotides" (letters: A, T, C, G) - to encode characters.
![before](https://user-images.githubusercontent.com/34771956/77928643-f6dd6c80-72a8-11ea-978e-7d008721fea2.png)

After encoding, mutations selected by user are applied to encoded sequence. 
Hence every letter has different codon, change of just one letter in sequence can change the original meaning.

**Possible mutations**

1. Deletion - deletes one nucleotide at random.

2. Duplication - duplicates one nucleotide at random.

3. Insertion - inserts random nucleotide at random index.

4. Inversion - inverts part of sequence of random length.

~~5. Substitution - replaces one nucleotide for other at random~~ (needs debugging)

6. Translocation - cuts part of sequence of random length and pastes it into random index.


![encoding](https://user-images.githubusercontent.com/34771956/77928652-f9d85d00-72a8-11ea-98ab-fd8b906c2f1e.png)

Another important thing is that sequence is decoded also in triplets, so single change in length (like insertion or duplication) shifts reading frame, so each codon after this mutation is read improperly.
Also there are multiple START and STOP codons (code is degenerated), so that decoding of mutated sequence can start too late, or terminate prematurely.
Without knowing mutation key, it is virtually impossible to retrieve original meaning of encoded text.
![after](https://user-images.githubusercontent.com/34771956/77928659-fc3ab700-72a8-11ea-8c7f-372f4d1dce82.png)

**How to run?**

Just open repository in terminal and type ```mvn clean compile exex:java```
, popup window should appear.

***How to encode?***

1.Click "LOAD FILE" button and upload text file you want to encode.

2.Select checkboxes of mutations you want to include.

3.Click "ENCODE". Mutation key is printed in textfield called "Mutation key".
Popup should appear informing you, that mutation key is copied to your clipboard. Save it to be able do decode this file.
Encoded file (called "Encoded.txt") is saved in the same directory, as loaded file.

***How to decode?***

1.Click "LOAD FILE" button and upload text file you want to decode ("Encoded.txt" by default).

2.In textfield called "Mutations key" type or paste mutations key that was generated during encoding.

3.Click "DECODE". Decoded file (called "Decoded.txt") is saved in the same directory, as loaded file.


**Limitations:**

Hence codons are triplets of four letters there are only 64 characters possible at maximum (64 combinations of four "nucleotides" taken three at a time).
There are 26 letters in English alphabet (52 including lowercase and uppercase), 10 digits (0-9) and 33 special characters.
So in order to include more special characters and multiple START/STOP codons original text is encoded and decoded as uppercase.
Also, some special characters are removed during pre-processing of input text file.


**Possible fixes would include:**

1.Adding more "nucleotides", which could increase number of possible codons to 125 in case of 5 available nucleotides, or 216 in case of 6 nucleotides.

2.Changing codon structure from triplet to quadruplet, which would give 256 (4 * 4 * 4 * 4) possible combinations.

3.Adding special sequence of characters starting or ending uppercase/lowercase sequence, or substituting special characters. However this would increase numbers of possible errors.


**TO DO:** Debug substitutor, so that it would not fail to decode propperly.
