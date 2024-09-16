run:
	@echo "Server running on port 8080"
	./gradlew bootRun

up:
	docker-compose up -d --build

down:
	docker-compose down -v

restart:
	docker-compose restart

stop:
	docker-compose stop
