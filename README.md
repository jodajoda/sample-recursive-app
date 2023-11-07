# Search application

With this application, you can list the unique file names in the specified directories from the server's directories.

* Starts two instance of the app
* Uses Postgres database

### Endpoints:

* GetUniqueFileNames:
  * Input parameter: Directory name
  * Result: Unique result of file names

* History:
  * Input parameter: Directory name
  * Result: Search history of the directory

### Running the application locally

```shell
make build run
```

### Try the application

Open swagger ui in your browser.

* http://localhost:8081/swagger-ui/index.html#
* http://localhost:8082/swagger-ui/index.html#

