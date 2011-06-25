<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<div id="content">
<h1 class="notopmargin">Password Information</h1>
<form action="registercarpoolpage2.html" method="post"
	class="contentmargin">
<fieldset>

<table width="95%">
	<tr>
		<td width="40%" height="30%"><label>Car Owner:</label></td>
		<span id="spryradio1">
		<td><input type="radio" name="carOwner" value="radio"
			id="carOwner_0" /> <label>Yes</label></td>
		<td><input type="radio" name="carOwner" value="radio"
			id="carOwner_1" /> <label>No</label></td>
		</span>
	</tr>
	<tr>
		<td><label>Valid Licence:</label></td>
		<span id="spryradio2">
		<td><input type="radio" name="validLincense" value="radio"
			id="validLincense_0" /> <label>Yes</label></td>
		<td><input type="radio" name="validLincense" value="radio"
			id="validLincense_1" /> <label>No</label></td>
		</span>
	</tr>
	<tr>
		<td><label>Gender:</label></td>
		<span id="spryradio3">
		<td><input type="radio" name="gender" value="radio" id="gender_0" />
		<label>Yes</label></td>
		<td><input type="radio" name="gender" value="radio" id="gender_1" />
		<label>No</label></td>
		</span>
	</tr>
	<tr>
		<td><label>Are you a smoker?</label></td>
		<span id="spryradio4">
		<td><input type="radio" name="smoker" value="radio" id="smoker_0" />
		<label>Yes</label></td>
		<td><input type="radio" name="smoker" value="radio" id="smoker_1" />
		<label>No</label></td>
		</span>
	</tr>
	<tr>
		<td><label>Vehicle make:</label></td>
		<td colspan="2"><select name="vehicleMake">
			<option>--SELECT--</option>
		</select></td>
	</tr>
	<tr>
		<td><label>Vehicle Model:</label></td>
		<td colspan="2"><select name="vehicleModel">
			<option>--SELECT--</option>
		</select></td>
	</tr>
	<tr>
		<td><label>Vehicle Type:</label></td>
		<td colspan="2"><select name="vehicleType">
			<option>--SELECT--</option>
		</select></td>
	</tr>
</table>
<div class="topspace buttons"><input class="button"
	name="nextStep" type="submit" value="Next Step - Travel Details" /></div>
</fieldset>
</form>
</div>

<script type="text/javascript">
	var spryradio1 = new Spry.Widget.ValidationRadio("spryradio1");
	var spryradio2 = new Spry.Widget.ValidationRadio("spryradio2");
	var spryradio3 = new Spry.Widget.ValidationRadio("spryradio3");
	var spryradio4 = new Spry.Widget.ValidationRadio("spryradio4");
</script>
