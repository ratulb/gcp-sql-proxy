docker build -t gcp-sql-proxy:latest .

docker tag gcp-sql-proxy ratulb/gcp-sql-proxy
docker login
docker push ratulb/gcp-sql-proxy

docker run -e DB_NAME="jdbc:mysql://127.0.0.1:3306/testdb" \
	-e DB_USER=gcp-sql-proxy -e DB_PASS=password --network=host \
	docker.io/ratulb/gcp-sql-proxy --name gcp-sql-proxy
