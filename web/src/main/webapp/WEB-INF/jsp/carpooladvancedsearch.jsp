<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<div id="content">
<h1 class="notopmargin">Search Car Pools - Advanced Search</h1>
<p class="paragraph_style_1" align="right"><a
	class="common_link_style" href="carpoolsimplesearch.html">Simple
Search Options</a></p>
<form action="homepage.html" method="post" class="contentmargin">
<fieldset>
<table width="95%">
	<tr>
		<td><label>Travel Days:</label></td>
	</tr>
	<tr>
		<td><input name="monday" type="checkbox" value="" />Monday</td>
		<td><input name="tuesday" type="checkbox" value="" />Tuesday</td>
		<td><input name="wednesday" type="checkbox" value="" />Wednesday</td>
		<td><input name="thursday" type="checkbox" value="" />Thursday</td>
	</tr>
	<tr>
		<td><input name="friday" type="checkbox" value="" />Friday</td>
		<td><input name="saturday" type="checkbox" value="" />Saturday</td>
		<td><input name="sunday" type="checkbox" value="" />Sunday</td>
		<td>&nbsp;</td>
	</tr>
</table>
<table class="topspace" width="95%">
	<tr>
		<td><label>Earliest Departure Time:</label></td>
		<td><select name="earlientDepartureTi/me">
			<option>--ANY--</option>
		</select></td>
		<td><label>Latest Departure Time:</label></td>
		<td><select name="latestDepartureTime">
			<option>--ANY--</option>
		</select></td>
	</tr>
</table>
<p>Note: if you don't specify a "to" time, the search will return
only those matching the "from" time. If you specify a time range, the
search will return those matching the range searched for.</p>
<table width="95%">
	<tr>
		<td><label>One Way / Return:</label></td>
		<span id="spryradio1">
		<td><input type="radio" name="Journey" value="radio"
			id="Journey_0" /> <label>OneWay</label></td>
		<td><input type="radio" name="Journey" value="radio"
			id="Journey_1" /> <label>Return</label></td>
		</span>
	</tr>
</table>

<table class="topspace" width="95%">
	<tr>
		<td width="45%" colspan="2">
		<h2 class="item" style="margin-top: 0%;">Travelling From</h2>
		</td>
		<td width="45%" colspan="2">
		<h2 class="item" style="margin-top: 0%;">Travelling To</h2>
		</td>
	</tr>
	<tr>
		<td width="25%"><label>District</label></td>
		<td width="25%"><label>Region</label></td>
		<td width="25%"><label>District</label></td>
		<td width="25%"><label>Region</label></td>
	</tr>
	<tr>
		<td><select name="fromDistrict">
			<option>Mauritius</option>
		</select></td>
		<td><select name="fromRegion">
			<option>Mauritius</option>
		</select></td>
		<td><select name="toDistrict">
			<option>Mauritius</option>
		</select></td>
		<td><select name="toRegion">
			<option>Mauritius</option>
		</select></td>
	</tr>
</table>

<table class="topspace" width="95%">
	<tr>
		<td width="20%"><label>Age Group:</label></td>
		<td width="50%"><select name="ageGroup">
			<option>--SELECT ALL--</option>
		</select></td>
		<td width="30%"><label>Number of interested passengers:</label></td>
		<td width="5%"><input name="numInterestedPassenger" type="text" /></td>
	</tr>
	<tr>
		<td><label>Driver Gender:</label></td>
		<span id="spryradio2">
		<td><input type="radio" name="driverGender" value="radio"
			id="driverGender_0" /> Male Only</td>
		<td><input type="radio" name="driverGender" value="radio"
			id="driverGender_1" /> Female Only</td>
		<td><input type="radio" name="driverGender" value="radio"
			id="driverGender_2" /> Both</td>
		</span>
	</tr>
	<tr>
		<td><label>Share Costs:</label></td>
		<span id="spryradio3">
		<td><input type="radio" name="shareCost" value="radio"
			id="shareCost_0" /> Yes</td>
		<td><input type="radio" name="shareCost" value="radio"
			id="shareCost_1" /> No</td>
		</span>
	</tr>
</table>

<div class="topspace buttons"><input class="button"
	name="register" type="submit" value="Find Available Car Pool" /></div>
</fieldset>
</form>
</div>
<script type="text/javascript">
	var spryradio1 = new Spry.Widget.ValidationRadio("spryradio1");
	var spryradio2 = new Spry.Widget.ValidationRadio("spryradio2");
	var spryradio3 = new Spry.Widget.ValidationRadio("spryradio3");
</script>
