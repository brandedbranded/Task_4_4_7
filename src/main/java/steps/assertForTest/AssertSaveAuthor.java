package steps.assertForTest;

import models.responsesPositive.ResponseAuthorSave;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertSaveAuthor {

    public static void verifySaveAuthorResponse(ResponseAuthorSave author) {
        assertNotNull(author.getAuthorId());
        assertTrue(author.getAuthorId() > 0);
    }
}
