package com.raley.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raley.controller.VendorController;
import com.raley.service.UserService;
import org.mockito.Mockito;
public class VendorControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(VendorControllerTest.class);
    private VendorController vendorController;
    private UserService userService;
    private MockMvc mockMvc;

    public VendorControllerTest() {
    	userService = Mockito.mock(UserService.class);
    	vendorController = new VendorController(userService);
    }

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(vendorController)
                .setControllerAdvice(new Exception())
                .build();
    }
    @Test
    public void saveVendor() throws Exception {
    	
    	String uri = "/vendor/register";
     	/*request.setAmount(BigDecimal.valueOf(d));
    	request.setSoldToPartner("soldToPartner");
     	request.setSoldToPartnerUser("soldToPartnerUser");
     	request.setTire2Partner("tire2Partner");
     	request.setTire2PartnerUser("tire2PartnerUser");
		String inputJson = mapToJson(request);
		logger.info("Request : "+inputJson);*/
       /* mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(inputJson)
                .header("Content-Type","application/json"))*/
//                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
       /* mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(inputJson)
                .header("Content-Type","application/json"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()))
                .andExpect(MockMvcResultMatchers.xpath("", "%s")
                        .string(containsString("")));*/
    }
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
     }
}
