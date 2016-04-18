package femr.ui.views.admin.users;

import femr.common.models.UserItem;
import femr.ui.models.admin.users.ManageViewModelGet;
import java.util.List;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Rectangle;
import java.awt.BorderLayout;



public class UsersApplet {

    ManageViewModelGet mvmg = new ManageViewModelGet();
    List<UserItem> userList = mvmg.getUsers();
    Integer totalUsers = userList.size();
    UserItem tempUser;
    JTable userTable = getTable();
    JButton editButton = new JButton("Edit");
    JButton enableDisableButton = new JButton("Enable / Disable");
    JTextField userIDField = new JTextField();
    JFrame frame;

    private void buildFrame() {
        frame = new JFrame("Users");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addStuffToFrame();
        frame.setVisible(true);
    }

    private void addStuffToFrame() {
        final JTable table = getTable();
        final JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        final JButton next = new JButton("next");
        final JButton prev = new JButton("prev");

        ActionListener al = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Rectangle rect = scrollPane.getVisibleRect();
                JScrollBar  bar = scrollPane.getVerticalScrollBar();
                int blockIncr = scrollPane.getViewport().getViewRect().height;
                if (e.getSource() == next) {
                    bar.setValue(bar.getValue() + blockIncr);
                } else if (e.getSource() == prev) {
                    bar.setValue(bar.getValue() - blockIncr);
                }
                scrollPane.scrollRectToVisible(rect);
            }
        };

        ActionListener a2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == editButton){

                }
            }
        };

        next.addActionListener(al);
        prev.addActionListener(al);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prev);
        buttonPanel.add(next);
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(userIDField, BorderLayout.SOUTH);
        panel.add(editButton, BorderLayout.SOUTH);
        panel.add(enableDisableButton, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);

    }


    private JTable getTable() {
        String[] colNames = new String[]{"Edit", "First Name", "Last Name", "Email", "About", "Role", "Last Login", "Toggle"};

        String[][] data = new String[totalUsers][colNames.length];
        for (int i = 0; i < totalUsers; i++) {
            for (int j = 0; j < colNames.length; j++) {
                tempUser = mvmg.getUser(i);
                switch (j){
                    case 0: //Edit
                        data[i][j] = Integer.toString(tempUser.getId());    //TODO add edit button here
                        break;
                    case 1: //First Name
                        data[i][j] = tempUser.getFirstName();
                        break;
                    case 2: //Last Name
                        data[i][j] = tempUser.getLastName();
                        break;
                    case 3: //Email
                        data[i][j] = tempUser.getEmail();
                        break;
                    case 4: //About
                        data[i][j] = tempUser.getNotes();
                        break;
                    case 5: //Role
                        data[i][j] = rolesString(tempUser);   //TODO make function that appends roles to a string and returns the string
                        break;
                    case 6: //Last Login
                        data[i][j] = tempUser.getLastLoginDate();
                        break;
                    case 7: //Toggle
                        data[i][j] = "";    //TODO add toggle button here
                        break;
                }
            }
        }

        return new JTable(data,colNames);
    }

    private String rolesString(UserItem user)
    {
        List<String> roles = user.getRoles();
        String rolesString = "";
        for(int i=0; i<roles.size(); i++)
            rolesString += roles.get(i);
        return rolesString;
    }
}
