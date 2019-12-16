package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.login.LoginPage;
import pages.notes.NotesPage;
import pages.feed.UserMainPage;

import java.util.List;

public class NoteTest extends TestBase {
    private static final int SIZE_NOTE = 10;

    @Test
    public void addNote() {
        new LoginPage(driver).login(getTechnoBot());
        final UserMainPage userMainPage = new UserMainPage(driver);
        final String note = generateRandomString(SIZE_NOTE);
        final NotesPage notesPage = userMainPage.createNote(note).clickNotesBtn();
        final List<String> keeps = notesPage.getNotes();
        Assert.assertTrue("Note wasn't added", keeps.contains(note));
    }
}
