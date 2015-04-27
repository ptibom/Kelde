package se.computerscience.kelde;

import se.computerscience.kelde.controller.ProjectController;
import se.computerscience.kelde.model.Project;
import se.computerscience.kelde.view.ProjectView;
import javax.swing.SwingUtilities;

/*
  Application entry class (if using standard java and Swing)
*/
public final class TemporaryMain {
    private TemporaryMain() {
		/* No instances allowed! */
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final Project project = new Project();
            final ProjectView projectView = new ProjectView(project);

            ProjectController.create(project, projectView);
            projectView.setVisible(true);
        });
    }
}
