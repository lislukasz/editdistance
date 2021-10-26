# Results:

Testing set size: 32768 chars

### Glossary:

* Apache: org.apache.commons:commons-text:1.9
* Standford: edu.stanford.nlp:stanford-corenlp:4.3.1

### Full testing set:

#### Apache:

* Duration: 658 365 000 ns
* Distance: 28834

#### Standford:

* Issue: java.lang.OutOfMemoryError: Java heap space

### Half testing set:

#### Apache:

* Duration: 352 203 000 ns
* Distance: 14429

#### Standford:

* Issue: java.lang.OutOfMemoryError: Java heap space

### 1000 chars testing set:

#### Apache:

* Duration: 17 546 000
* Distance: 888

#### Standford:

* Duration: 58 412 000
* Distance: 886.0

### Maximum possible testing set:

#### Apache:

* Duration: 325 293 000
* Distance: 7044

#### Standford:

* Duration: 361 277 000
* Distance: 7041.0

### Conclusion

#### Apache:

- pros:
    - better performance
    - ability to process huge strings
- cons:
    - missing feature to provide own weights for operations (replace, delete, insert)

#### Standford:

- pros:
    - feature to provide own weights for operations (replace, delete, insert)
- cons:
    - poor performance
    - no ability to process huge strings
