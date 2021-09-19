## Requirements
* java 11
* maven
* postgresql
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

## Explanation List API

* API CATEGORY
 * ```SH /api/v1/category/saveOrUpdate ```
    Method: POST
    Request Body: 
    ```SH
    {
      "id": 6,
      "name": "Category Test 6"
    }
    ```
 api ini digunakan untuk create atau update category, jika ingin create id nya set null/0, jika update masukan id tujuan
 * ```SH /api/v1/category/delete/{categoryId}```
    Method: DELETE
    api ini digunakan untuk delete category by id,
 
 * ```SH /api/v1/category/search```   
    Method: POST
    Request Body: 
    ```SH 
    {
            "data": "",
            "pageAt": 1,
            "pageSize": 2,
            "sortBy": "id",
            "sortDirection": "DESC"
          }```
   api ini digunakan untuk mendapat list data category dan bisa filter by name di properti data, dan bisa juga menggunakan paging, 
   untuk sortBy itu menggunakan key pada response json yang ingin di sorting.
 
* API MOVIE
  * ```SH /api/v1/movie/saveOrUpdate ```
  Method: POST
  Request Body: 
  ```sh 
    {
      "categories": [
        1,2
      ],
      "description": "ini text description, jangan diliat",
      "id": 0,
      "imageBase64": "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",
      "imageName": "kk.jpg",
      "rate": 9.1,
      "title": "Aku hanya badut biasa"
    }
  ```
  ini api untuk create movie, categorie menggunakan id dari list category, dan jika ingin create id nya set null/0, 
  jika update idnya beri movie id yang ingin diupdate.
  
  * ```SH /api/v1/movie/delete/{movieId}``` 
  Method: DELETE
  ini api untuk delete movie by id
  
  * ```SH /api/v1/movie/detail/{movieId}```
  Method: POST
  ini api untuk liat detail movie by id movie
  
  * ```SH /api/v1/movie/search```
  Method: POST
  Request Body: 
  ```SH 
    {
      "data": {
        "categoryId": 0,
        "query": ""
      },
      "pageAt": 1,
      "pageSize": 2,
      "sortBy": "id",
      "sortDirection": "DESC"
    }
  ```
  ini api untuk liat list movie dan bisa menggunakna filter, jika ingin meliat semua category set null/0 jika ingin liat movie berdarkan category set categoryId,
  filter query berdarkan title OR description, untuk value sorting ada ASC atau DESC.

to see list of api, u can see on this link http://localhost:8080/swagger-ui.html