<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <script src="<c:url value="/resources/SpryAssets/SpryValidationRadio.js"/>" type="text/javascript"></script>
	<link href="<c:url value="/resources/styles/register.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/SpryAssets/SpryValidationRadio.css"/>" rel="stylesheet" type="text/css" />
	<div id="content">
	  <h1 class="contentmargin notopmargin"> Your Information </h1>
     	<form:form  action="saveuser" method="post" id="member_registration" class="contentmargin">
        	<fieldset>
            	<h2 class="item" style="margin-top:0%;">Account Details</h2>
                <table id="account_details" width="100%">
  					<tr>
   					  	<td><label>Username:</label></td>
		 			  	<td><input name="username" type="text" /></td>
    					<td><label>Age Group:</label></td>
    					<td>
                        	<select name="age_group">
                       			<option value="">--SELECT--</option>
                                <option value="18-25">18-25</option>
								<option value="26-32">26-32</option>
								<option value="33-40">33-40</option>
								<option value="40+">40+</option>
                            </select>
                        </td>
  					</tr>
  					<tr>
    					<td><label>First Name:</label></td>
    					<td><input name="firstname" type="text" /></td>
    					<td><label>Last Name:</label></td>
    					<td><input name="lastname" type="text" /></td>
  					</tr>
  					<tr>
  						<td><label>Password:</label></td>
    					<td><input name="password" type="text" /></td>
    					<td><label>Confirm Password:</label></td>
    					<td><input name="confirmpassword" type="text" /></td>
  					</tr>
  					<tr>
  						<td><label>Email:</label></td>
    					<td><input name="email" type="text" /></td>
    					<td><label>Confirm Email:</label></td>
    					<td><input name="confirmemail" type="text" /></td>
  					</tr>
				</table>
                
                <h2 class="item">Other Details</h2>
                <table width="60%">
  					<tr>
   					  <td width="35%"><label>Car Owner:</label></td>
                      <span id="spryradio1">	
                        <td>
                        	<div align="center" class="radio_button">
                        		<input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_0" />
                            	<label>Yes</label>
                            </div>
                      	</td>
   					  	<td>
                       	  <div align="center" class="radio_button">
   					      		<input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_1" />
                            	<label>No</label>
				      	  </div>
                       	</td>
                      </span>
  					</tr>
  					<tr>
   					  <td><label>Valid Licence:</label></td>
                      <span id="spryradio2">
                        <td>
                        	<div align="center" class="radio_button">
                            	<input type="radio" name="RadioGroup2" value="radio" id="RadioGroup2_0" />
                            	<label>Yes</label>
                            </div>
						</td>
    					<td>
                        	<div align="center" class="radio_button">
                            	<input type="radio" name="RadioGroup2" value="radio" id="RadioGroup2_1" />
                            	<label>No</label>
                            </div>
                        </td>
                      </span>
  					</tr>
  					<tr>
   					  <td><label>Gender:</label></td>
                      <span id="spryradio3">
                        <td>
                        	<div align="center" class="radio_button">
                            	<input type="radio" name="RadioGroup3" value="radio" id="RadioGroup3_0" />
                                <label>Yes</label>
                            </div>
                        </td>
    					<td>
                        	<div align="center" class="radio_button">
                            	<input type="radio" name="RadioGroup3" value="radio" id="RadioGroup3_1" />
                            	<label>No</label>
                            </div>
                        </td>	
                      </span>
  					</tr>
				</table>

				<h2 class="item">Your Contact Details</h2>
                <p>To list all suburbs in your State, select State, change Region to Search All and then select the Suburb. </p>
            	<table class="ur_contact_details" width="90%">
  					<tr>
                    	<td><label>Country:</label></td>
    					<td><label>State:</label></td>
    					<td><label>Region:</label></td>
    					<td><label>Town/Suburb:</label></td>
  					</tr>
  					<tr>
                    	<td>
                        	<select name="country">
                        		<c:forEach items="${countries}" var="countryVO" >
  									<option><c:out value="${countryVO.countryName}" /></option>
  								</c:forEach>
                            </select>
                        </td>
    					<td>
                        	<select name="state">
                            	<option>--SELECT--</option>
                            </select>
                        </td>
    					<td>
                        	<select name="region">
                            	<option>--SELECT--</option>
                            </select>
                        </td>
   						<td>
                        	<select name="town">
                            	<option>--SELECT--</option>
                            </select>
                        </td>
  					</tr>
				</table>
                <table class="ur_contact_details" width="80%">
  					<tr>
    					<td><label>Address (street):</label></td>
    					<td><label>Postcode:</label></td>
    					<td><label>Phone:</label></td>
  					</tr>
  					<tr>
    					<td>
				    	  <input size="40%" type="text" name="address" id="address" />
                        </td>
    					<td>
                       	  <input size="10%" type="text" name="postcode" id="postcode" />
                        </td>
    					<td>
                       	  <input size="17%" type="text" name="phone" id="phone" />
                        </td>
  					</tr>
				</table>

				<h2 class="item">Your Preferences</h2>
				<input name="notification" type="checkbox" value="" />
           	  <label>I would like to recieve updates on new Car Pools for my area</label>
           	  <table width="60%" class="topspace">
  					<tr>
    					<td width="35%"><label>Share Costs:</label></td>
    					<span id="spryradio3">	
                        	<td>
                        		<div align="center" class="radio_button">
                        			<input type="radio" name="RadioGroup3" value="radio" id="RadioGroup3_0" />
                            		<label>Yes</label>
                            	</div>
                      		</td>
   					  		<td>
                       	  		<div align="center" class="radio_button">
   					      			<input type="radio" name="RadioGroup3" value="radio" id="RadioGroup3_1" />
                            		<label>No</label>
				      	  		</div>
                       		</td>
                      	</span>
  					</tr>
  					<tr>
    					<td><label>Share Driving:</label></td>
    					<span id="spryradio4">	
                        	<td>
                        		<div align="center" class="radio_button">
                        			<input type="radio" name="RadioGroup4" value="radio" id="RadioGroup4_0" />
                            		<label>Yes</label>
                            	</div>
                      		</td>
   					  		<td>
                       	  		<div align="center" class="radio_button">
   					      			<input type="radio" name="RadioGroup4" value="radio" id="RadioGroup4_1" />
                            		<label>No</label>
				      	  		</div>
                       		</td>
                      	</span>
  					</tr>
				</table>
				<div class="topspace buttons">
                	<input class="button" name="clearform" type="reset" value="Clear Form" />
                    <input class="button" name="register" type="submit" value="Register Now" />
                </div>
            </fieldset>
        </form:form>
    </div>
    
    <script type="text/javascript">
		var spryradio1 = new Spry.Widget.ValidationRadio("spryradio1");
		var spryradio2 = new Spry.Widget.ValidationRadio("spryradio2");
		var spryradio3 = new Spry.Widget.ValidationRadio("spryradio3");
		var spryradio4 = new Spry.Widget.ValidationRadio("spryradio4");
	</script>