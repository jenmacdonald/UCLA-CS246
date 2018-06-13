#!/bin/bash

QUERY=$1

curl -XGET 'localhost:9200/task3a/_search?pretty' -H 'Content-Type: application/json' -d'
{
  "query": {
    "bool": {
      "must": [
        { 
            "match": { 
                "title": "'$QUERY'",
                "boost": 10
            }
        },
        {
            "match": { 
                "abstract": "'$QUERY'"
            }
        }
      ],
      "must_not": [
        { 
            "match": { 
                "sections": "'$QUERY'",
            }
        }
      ]
    }
  }
}
'
