package pandemiconline2.panonlinebackend.API.ViewModel;

import lombok.Getter;

@Getter
public class UserLoginViewModel
{
    private String username;
    private String password;

    public UserLoginViewModel(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
}
