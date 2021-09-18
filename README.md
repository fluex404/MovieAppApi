## Requirements
* java 11
* maven
* docker(optinal, if you not want to install db in your device manually)
* text editor: intelliJ, STS, eclipse

## How To Run Apps
Run database on docker
```sh
sudo docker run -it --rm --name test-postgres -e POSTGRES_PASSWORD=Nostra -e POSTGRES_USER=Nostra -e POSTGRES_DB=NostraMovie -p 5432:5432 postgres:13
```
Get project
```sh
git clone https://github.com/fluex404/MovieApp
```
Run project
```sh 
cd MovieApp
```
```sh 
mvn spring-boot:run
```