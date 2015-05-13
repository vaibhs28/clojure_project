(ns myproject.core
   (:require [cheshire.core :refer :all])
  (:gen-class))

(use '[clojure.string :only (split triml)])

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn read_file
  "read a csv file."
  ([filename]
  (with-open [rdr (clojure.java.io/reader filename)]
    (doall (line-seq rdr)) ) ))

 (defn read_csv_file_as_json
  "read a csv file and returns json data"
  ([filename]
 (generate-string {:data (map #(split % #",") (read_file filename )) })))
 
 (read_csv_file_as_json (.getFile (clojure.java.io/resource "actors.csv")))