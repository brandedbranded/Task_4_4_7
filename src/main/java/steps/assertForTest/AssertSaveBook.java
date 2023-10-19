package steps.assertForTest;

import models.responsesPositive.ResponseBookSave;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertSaveBook {

    public static void verifySaveBookResponse(ResponseBookSave bookResponse) {
        assertTrue(bookResponse.getBookId() > 0);
    }
}
