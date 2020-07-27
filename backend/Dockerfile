FROM openjdk:8-jdk-alpine
ENV WEATHER_API_URL https://api.openweathermap.org/data/2.5/weather?q=
ADD target/weather-application.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar", "--weather.api.url=${WEATHER_API_URL}"]
