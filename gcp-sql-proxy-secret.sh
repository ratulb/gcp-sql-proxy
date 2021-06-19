kubectl create secret generic gcp-sql-proxy-secret \
  --from-literal=username=gcp-sql-proxy \
  --from-literal=password=password \
  --from-literal=database=jdbc:mysql://127.0.0.1:3306/testdb
