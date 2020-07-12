package com.mentor.link.api.filter;

import com.mentor.link.Constants;
import com.mentor.link.api.common.mapper.UserSearchFilterMapper;
import com.mentor.link.api.filter.model.UserSearchFilterDto;
import com.mentor.link.persistence.model.UserSearchFilter;
import com.mentor.link.service.UserSearchFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(Constants.API_V1 + "filter")
@RestController
public class UserSearchFilterController {

    private final UserSearchFilterService userSearchFilterService;
    private final UserSearchFilterMapper userSearchFilterMapper = UserSearchFilterMapper.INSTANCE;

    @Autowired
    public UserSearchFilterController(UserSearchFilterService userSearchFilterService) {
        this.userSearchFilterService = userSearchFilterService;
    }

    @GetMapping
    public UserSearchFilterDto getFilter() {
        final UserSearchFilter filter = userSearchFilterService.getFilter();
        return userSearchFilterMapper.userSearchFilterToDto(filter);
    }

    @PostMapping
    public void setFilter(@RequestBody UserSearchFilterDto userSearchFilterDto) {
        final UserSearchFilter userSearchFilter = userSearchFilterMapper.userSearchFilterToEntity(userSearchFilterDto);
        userSearchFilterService.saveFilter(userSearchFilter);
    }
}
