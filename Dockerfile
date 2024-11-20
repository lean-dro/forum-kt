FROM maven:3-openjdk as builder
LABEL key="lean-dro"

WORKDIR /builder

COPY . .

RUN mvn clear package -DskipTests -Dcheckstyle.skip=true

FROM openjdk:17-slim

WORKDIR /app

COPY --from=builder /build/target/*.jar /app/app.jar

CMD [ "executable" ]

