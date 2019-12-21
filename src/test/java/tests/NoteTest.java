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
        final UserMainPage userMainPage = new LoginPage(driver).login(getTechnoBot());
        final String note = generateRandomString(SIZE_NOTE);
        final NotesPage notesPage = userMainPage.createNote(note).clickNotesBtn();
        Assert.assertTrue("Note wasn't added", notesPage.isNoteExist(note));
    }
}
