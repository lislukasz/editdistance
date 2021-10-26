# Results:

Testing set size: 32768 chars

Glossary:
Apache: org.apache.commons:commons-text:1.9
Standford: edu.stanford.nlp:stanford-corenlp:4.3.1


Full testing set:
Apache:
  Duration = 658 365 000 ns
  Distance = 28834
Standford:
 Issue: java.lang.OutOfMemoryError: Java heap space

Half testing set:
Apache:<br />
  Duration = 352 203 000 ns<br />
  Distance = 14429<br />
Standford:<br />
 Issue: java.lang.OutOfMemoryError: Java heap space<br />

1000 chars testing set:<br />
Apache:<br />
  Duration = 17 546 000<br />
  Distance = 888<br />
Standford:<br />
  Duration = 58 412 000<br />
  Distance = 886.0<br />

Maximum possible testing set:<br />
Apache:<br />
  Duration = 325 293 000<br />
  Distance = 7044<br />
Standford:<br />
  Duration = 361 277 000<br />
  Distance = 7041.0<br />

Apache:<br />
  pros:<br />
   - better performance
   - ability to process huge strings
  cons:<br />
   - missing feature to provide own weights for operations (replace, delete, insert)
Standford:<br />
  pros:<br />
   - feature to provide own weights for operations (replace, delete, insert)
  cons:<br />
   - poor performance
   - no ability to process huge strings
