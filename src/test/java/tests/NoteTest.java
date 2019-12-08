package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.NotesPage;
import pages.UserMainPage;

import java.util.List;

public class NoteTest extends TestBase {
    private static final int SIZE_NOTE = 10;

    @Test
    public void addNote() {
        new LoginPage(driver).login(getTechnoBot());
        final UserMainPage userMainPage = new UserMainPage(driver);
        final String note = generateRandomString(SIZE_NOTE);
        userMainPage.createNote(note);
        userMainPage.clickNotesBtn();
        final NotesPage notesPage = new NotesPage(driver);
        final List<String> keeps = notesPage.getNotes();
        Assert.assertTrue("Note wasn't added", keeps.contains(note));
    }
}
