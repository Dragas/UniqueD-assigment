# UniqueD assignment

Sorts provided comma separated value input file depending on chosen algorithm

## Usage

```bash
./app [sorting algorithm] [csv file]
    where sorting algorithm is one of:
    -m | --merge for merge sort
    -b | --bubble for bubble sort
    -h | --heap for heap sort
```


## Building

```bash
mvn package
```

Produces executable in target/appassembler/bin folder. To run it, 
you may call it from current directory `./target/appassembler/bin/app`. See [Usage](#usage)

## Requirements

 
* System UI: command line interface.
* Implemented sorting algorithms:
  * Mergesort
  * Heapsort
  * Bubblesort
* Permits adding more sorting algorithms after implementing `Sorter` interface via `SortingAlgorithmFactory#register(String, Class<? extends Sorter>)`
* Benchmarking using `System.nanoTime()`
