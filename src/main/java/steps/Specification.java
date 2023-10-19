package steps;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.BookSaveAuthorExmp.BookSaveAuthorExmp;
import models.requests.RequestAuthorSave;
import models.requests.RequestBookSave;
import models.requests.RequestGetAllBooksXML;
import models.responsesPositive.ResponseAuthorSave;
import models.responsesPositive.ResponseBookSave;
import models.responsesPositive.ResponseGetAllBooks;
import models.responsesPositive.ResponseGetAllBooksXmlList;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Specification {
    public static RequestSpecification reqSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setContentType(ContentType.JSON)
                .setPort(8080)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public static RequestSpecification reqSpecXML() {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setContentType(ContentType.XML)
                .setPort(8080)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public static ResponseSpecification respSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }

    public static ResponseAuthorSave reqSpecSaveAuthor(String firstName, String lastName, String middleName, int statusCode) {
        RequestAuthorSave author = new RequestAuthorSave(firstName, lastName, middleName);

        return given().spec(reqSpec())
                .body(author)
                .when()
                .post(EndPoints.saveNewAuthorURL)
                .then().spec(respSpec(statusCode))
                .extract().as(ResponseAuthorSave.class);
    }

    public static ResponseBookSave reqSpecSaveBook(String bookTitle, long authorId, int statusCode) {
        BookSaveAuthorExmp author = new BookSaveAuthorExmp(authorId);
        RequestBookSave book = new RequestBookSave(bookTitle, author);

        return given().spec(reqSpec())
                .body(book)
                .when()
                .post(EndPoints.saveNewBookURL)
                .then().spec(respSpec(statusCode))
                .extract().as(ResponseBookSave.class);
    }

    public static List<ResponseGetAllBooks> reqSpecGetAllBooks(String id, int statusCode) {
        return given().spec(reqSpec())
                .when()
                .get(EndPoints.getAllBooksURL, id)
                .then().spec(respSpec(statusCode))
                .extract().jsonPath().getList(".", ResponseGetAllBooks.class);
    }

    public static ValidatableResponse reqSpecGetAllBooksNegative(String id, int statusCode, String errorCode) {
        return given().spec(reqSpec())
                .when()
                .get(EndPoints.getAllBooksURL, id)
                .then().spec(respSpec(statusCode))
        .body("errorCode", equalTo(errorCode))
                ;
    }

    public static List<ResponseGetAllBooksXmlList> reqSpecGetAllBooksXML(int id, int statusCode) {
        RequestGetAllBooksXML author = new RequestGetAllBooksXML();
        author.setAuthorId(id);

        return given().spec(reqSpecXML())
                .body(author)
                .when()
                .post(EndPoints.getAllBooksXMLUrl)
                .then().spec(respSpec(statusCode))
                .extract().xmlPath().getList(".", ResponseGetAllBooksXmlList.class);
    }

    public static ValidatableResponse reqSpecGetAllBooksResponse(String id, int statusCode) {
        return given().spec(reqSpec())
                .when()
                .get(EndPoints.getAllBooksURL, id)
                .then().spec(respSpec(statusCode));
    }
}
