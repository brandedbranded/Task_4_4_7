package steps;

import models.requests.RequestAuthorSave;

public class BuilderAuthor {
    public static RequestAuthorSave buildAuthor (String firstName , String familyName, String secondName){
        return new RequestAuthorSave(firstName,familyName,secondName);
    }
}
