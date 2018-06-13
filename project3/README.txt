Changes made to SpellChecker file (renamed SpellChecker2):

calculateEM:
1) More weight given to the EM value if the edit distance is smaller.
2) Since vowels are the most likely to be misused (i.e. substituting an i instead of an e), weight is given if the strings of word and correction are the same, minus the vowels (a, e, i, o, u, y).
3) We check for sound-alike letters, like [c, s] and [j, g], that can also contribute to errors. If we check for these swapped letters we can catch some errors
4) We check for common silent letters that that make a word misspelled (like 'h' in "hour")
5) Double consonants edits should be fairly common, and we should give more weight to those as well