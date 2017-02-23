curl -X POST -H "Content-Type:application/json" -d "{ \"artist\": \"Iron Maiden\", \"album\": \"Fear of the Dark\", \"title\": \"Fear of the Dark\" }" http://localhost:8080/songs
curl -X POST -H "Content-Type:application/json" -d "{ \"artist\": \"Iron Maiden\", \"album\": \"A Matter of Life and Death\", \"title\": \"For the Greater Good of God\" }" http://localhost:8080/songs
curl -X PUT -H "Content-Type:application/json" -d "{ \"artist\": \"Iron Maiden\", \"album\": \"Fear of the Dark\", \"title\": \"Afraid to Shoot Strangers\" }" http://localhost:8080/songs/1
curl -X POST -H "Content-Type:application/json" -d "{\"artist\": \"System of a Down\", \"album\": \"Toxicity\", \"title\": \"Toxicity\" }" http://localhost:8080/songs
curl -X POST -H "Content-Type:application/json" -d "{\"artist\": \"System of a Down\", \"album\": \"Toxicity\", \"title\": \"Aerials\" }" http://localhost:8080/songs
curl -X GET -H "Content-Type:application/json" http://localhost:8080/songs
curl -X GET -H "Content-Type:application/json" "http://localhost:8080/songs/search/findByArtist?artist=Iron+Maiden"
curl -X GET -H "Content-Type:application/json" "http://localhost:8080/songs/search/findByAlbum?album=Toxicity"
curl -X GET -H "Content-Type:application/json" "http://localhost:8080/songs/search/findByArtistAndAlbum?artist=System+of+a+Down&album=Toxicity"