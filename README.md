# GitHub Tracer

GitHub Tracer is a Spring Boot application that allows searching and displaying GitHub user repositories. The application provides a simple REST API interface for retrieving repository information. Any displaying repository is not a fork.

## Required Parameters:
gitHubUserName: The GitHub username for which repositories are to be fetched.

The gitHubUserName parameter is not case sensitive.
## API Endpoint

```
GET /api/v1/repositories?name={gitHubUserName}
```
Returns a list of repositories for the GitHub user with the username {gitHubUserName}.


## Running the Project

#### Clone the repository:
```
git clone https://github.com/kacpertetela/github-tracer.git
cd github-tracer
cd GitHub-Tracer
```

#### Build the project using Maven:
```
mvn clean install
```
#### Run the application:
```
mvn spring-boot:run
```
#### The application will be available at http://localhost:8080.

## Example Usage
```
GET http://localhost:8080/api/v1/repositories?name=kacpertetela
```

## Sample Response
```
{
        "name": "CSManager",
        "branches": [
            {
                "name": "develop",
                "sha": "3690852f7339de5ef5e524608db6440790373fa2"
            },
            {
                "name": "features",
                "sha": "5121930b006cc54109ef4623b56740902e71c56f"
            },
            {
                "name": "master",
                "sha": "4602960a738fd5b4967526d2a995bcaa060adb21"
            }
        ]
    }
```

## Requirements
Java 21

Maven 3.6.3 or later


## License

[MIT](https://choosealicense.com/licenses/mit/)
