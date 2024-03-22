package boot.booty.controller;


import boot.booty.model.User;
import boot.booty.service.RoleService;
import boot.booty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String getAllUser(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String username = userDetails.getUsername();
        model.addAttribute("users", userService.getAllUser());
        model.addAttribute("user", userService.findByUsername(username));
        model.addAttribute("roles", roleService.getAllRole());
        return "admin";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "nameRoles", required = false) String roles) {
        user.setRoles(roleService.getByName(roles));
        userService.createUser(user);
        return "redirect:/admin";
    }

    @PostMapping ("/update/{id}")
    public String update(@ModelAttribute("users") User user,
                         @RequestParam(value = "roleName", required = false) String roles) {
        user.setRoles(roleService.getByName(roles));
        userService.editUser(user);
        return "redirect:/admin";
    }
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
