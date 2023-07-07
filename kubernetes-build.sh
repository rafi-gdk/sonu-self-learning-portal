docker run --name postgresql -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=123456789 -p 5432:5432 -d postgres
./gradlew clean build
docker build -f ./docker-images/Dockerfile -t sonu-self-learning-portal:latest .
kubectl apply -f ./kubernetes/deployment.yaml