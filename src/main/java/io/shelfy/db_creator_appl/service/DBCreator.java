package io.shelfy.db_creator_appl.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.shelfy.db_creator_appl.dto.CallDto;
import io.shelfy.db_creator_appl.dto.CallerDto;
import io.shelfy.db_creator_appl.entities.Call;
import io.shelfy.db_creator_appl.entities.Caller;
import io.shelfy.db_creator_appl.repository.CallRepository;
import io.shelfy.db_creator_appl.repository.CallerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DBCreator {
    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    CallerRepository callers;
    @Autowired
    CallRepository calls;

    public void addCalls() throws JsonParseException, JsonMappingException, IOException {
        CallDto[] callsDto = mapper.readValue(new File("C:\\Users\\User\\Desktop\\Disk\\db_creator_appl\\src\\main\\resources\\calls_mock_data.json"), CallDto[].class);
        System.out.println(callsDto.length);
        for (CallDto callDto : callsDto) {
            addCall(callDto);
        }
    }

    @Transactional
    public void addCall(CallDto callDto) {
        Caller caller = callers.findById(callDto.caller_id).orElse(null);
        Caller calledParty = callers.findById(callDto.called_party_id).orElse(null);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Call call = new Call(LocalDateTime.parse(callDto.timestamp, dtf), callDto.duration_in_seconds, caller, calledParty);
        calls.save(call);
    }

    public void addCallers() throws JsonParseException, JsonMappingException, IOException {
        CallerDto[] callerDto = mapper.readValue(new File("C:\\Users\\User\\Desktop\\Disk\\db_creator_appl\\src\\main\\resources\\callers_mock_data.json"), CallerDto[].class);
        for (CallerDto dto : callerDto) {
            addCaller(dto);
        }
    }

    public void addCaller(CallerDto dto) {
        Caller caller = new Caller(dto.id, dto.email, dto.first_name, dto.last_name, dto.gender, dto.image);
        callers.save(caller);
    }
}
