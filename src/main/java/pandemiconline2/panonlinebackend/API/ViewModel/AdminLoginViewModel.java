package pandemiconline2.panonlinebackend.API.ViewModel;

import lombok.Getter;

@Getter
public class AdminLoginViewModel
{
    private String username;
    private String password;

    public AdminLoginViewModel(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
}
