package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.feed.UserMainPage;
import pages.login.LoginPage;
import pages.notes.NotesPage;

public class NoteTest extends TestBase {
    private static final int SIZE_NOTE = 10;

    @Test
    public void addNote() {
        new LoginPage(driver).login(getTechnoBot());
        final UserMainPage userMainPage = new UserMainPage(driver);
        final String note = generateRandomString(SIZE_NOTE);
        final NotesPage notesPage = userMainPage.createNote(note).clickNotesBtn();
        Assert.assertTrue("Note wasn't added", notesPage.isNoteExist(note));
    }
}
