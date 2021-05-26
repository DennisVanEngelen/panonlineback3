package pandemiconline2.panonlinebackend.API.ViewModel;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter @Builder
public class UserViewModel
{
    private long ID;
    private String Username;
    private String EmailAddress;
}
