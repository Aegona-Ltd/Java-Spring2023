package com.example.baitapCrudApi.api;

import com.example.baitapCrudApi.dto.ResponseObject;
import com.example.baitapCrudApi.dto.UserDto;
import com.example.baitapCrudApi.dto.UserResponse;
import com.example.baitapCrudApi.entity.Users;
import com.example.baitapCrudApi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userapi")
public class UserControllerApi {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    //test
    @GetMapping("/")
    public String test(){
        return "timeoday";
    }

    //API add user
    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addUser(@RequestBody Users users){
        Optional<Users> users1 = userService.addUser(users);

        //chuyển đổi thực thể sang DTO
        UserDto userResponse = modelMapper.map(users1.get(), UserDto.class);
        if(users1.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(true, userResponse, "Thêm người dùng thành công")
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject(false, null, "Không thể thêm người dùng ")
            );
        }
    }

    //API update user
    @PutMapping("/update")
    public ResponseEntity<ResponseObject> updateUser(@RequestParam("id") int id, @RequestBody Users users){
        Optional<Users> users1 = userService.updateUser(id, users);

        //chuyển đổi thực thể sang DTO
        UserDto userResponse = modelMapper.map(users1.get(), UserDto.class);
        if(users1.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(true, userResponse, "Cập nhật người dùng thành công")
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject(false, null, "Không thể cập nhật người dùng ")
            );
        }
    }

    //API delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        ResponseObject apiResponse = new ResponseObject(true, null,"Xóa người dùng thành công");
        return new ResponseEntity<ResponseObject>(apiResponse, HttpStatus.OK);
    }

    //API lấy danh sách
    @GetMapping("/list/{pageNo}/{pagaSize}/{sortBy}")
    public ResponseEntity<ResponseObject> getAllUser(@PathVariable Integer pageNo, @PathVariable Integer pagaSize, @PathVariable String sortBy){
        Page<Users> users = userService.findPaginated(pageNo, pagaSize, sortBy);
        List<UserDto> userDto = new ArrayList<>();
        System.out.println(users);
        for (int i = 0; i < users.getContent().size(); i++) {
            userDto.add(modelMapper.map(users.getContent().get(i), UserDto.class));
        }
        UserResponse userResponses = new UserResponse();
        userResponses.setData(userDto);
        userResponses.setTotalPages(users.getTotalPages());
        userResponses.setTotalItems(users.getTotalElements());
        userResponses.setCurrentPage(users.getNumber());

        ResponseObject apiResponse = new ResponseObject(true, userResponses,"Hiển thị danh sách người dùng thành công");
        return new ResponseEntity<ResponseObject>(apiResponse, HttpStatus.OK);
    }

    //API lấy 1 user
    @GetMapping({"/{id}"})
    public ResponseEntity<ResponseObject> getOneUser(@PathVariable int id){

        Optional<Users> users = userService.getOneUser(id);
        //chuyển đổi thực thể sang DTO
        UserDto userResponse = modelMapper.map(users.get(), UserDto.class);
        System.out.println(userResponse);
        if(users.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(true, userResponse, "Đã tìm thấy người dùng có id = "+id)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject(false, null, "Không thể tìm thấy người dùng có id = "+id)
            );
        }
    }


}
