build:
	mvn clean package -DskipTests
run:
	docker build . -t sample-app:v1
	docker-compose up