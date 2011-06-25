<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<div id="content">
<h1 class="notopmargin">Travel Details</h1>
<form action="registercarpoolpage4.html" method="post"
	class="contentmargin">
<fieldset><label>Select the travel Days and the
amount of seats available for that day</label>
<table>
	<tr>
		<td width="20%"><input name="monday" type="checkbox" value="" />Monday</td>
		<td><input name="numOfSeatsAvailableMonday" type="text" value="0"
			class="seatsAvailable" /></td>
		<td width="20%"><input name="tuesday" type="checkbox" value="" />Tuesday</td>
		<td><input name="numOfSeatsAvailableTuesday" type="text"
			value="0" class="seatsAvailable" /></td>
		<td width="20%"><input name="wednesday" type="checkbox" value="" />Wednesday</td>
		<td><input name="numOfSeatsAvailableWednesday" type="text"
			value="0" class="seatsAvailable" /></td>
	</tr>
	<tr>
		<td><input name="thursday" type="checkbox" value="" />Thursday</td>
		<td><input name="numOfSeatsAvailableThursday" type="text"
			value="0" class="seatsAvailable" /></td>
		<td><input name="friday" type="checkbox" value="" />Friday</td>
		<td><input name="numOfSeatsAvailableFriday" type="text" value="0"
			class="seatsAvailable" /></td>
	</tr>
	<tr>
		<td><input name="saturday" type="checkbox" value="" />Saturday</td>
		<td><input name="numOfSeatsAvailableSaturday" type="text"
			value="0" class="seatsAvailable" /></td>
		<td><input name="sunday" type="checkbox" value="" />Sunday</td>
		<td><input name="numOfSeatsAvailableSunday" type="text" value="0"
			class="seatsAvailable" /></td>
	</tr>
</table>
<p>Note: You must specify how many seats are available in the field
after the day you selected</p>
<table width="45%">
	<tr>
		<td><label>Departure Time:</label></td>
		<td><select name="departureTime">
			<option>--ANY--</option>
		</select></td>
	</tr>
</table>
<h2 class="item">To</h2>
<table width="95%">
	<tr>
		<td width="25%"><label>District:</label></td>
		<td width="25%"><label>Region:</label></td>
	</tr>
	<tr>
		<td><select name="fromDistrict">
			<option>Mauritius</option>
		</select></td>
		<td><select name="fromRegion">
			<option>Mauritius</option>
		</select></td>
	</tr>
</table>
<p>To list all suburbs in your State, select State, change Region to
Search All and then select the Suburb.</p>
<table width="95%">
	<tr>
		<td><label>Additional Details:</label></td>
	</tr>
	<tr>
		<td><textarea name="addtionalDetails" cols="50%" rows="5%"></textarea>
		</td>
	</tr>
</table>

<div class="topspace buttons"><input class="button" name="goBack"
	type="submit" value="Previous Step - Car Pool Details" /> <input
	class="button" name="nextStep" type="submit"
	value="Next Step -  Complete Registration" /></div>
</fieldset>
</form>
</div>
