<html>
<head>
    <title>iCal Generator</title>
</head>
<body>
    <h1>iCal Generator</h1>

    <form id="addEvent" action="/edu.projectuz.mCal/addEvent" method="GET">
        Event name:<br>
        <input title="title" type="text"><br>

        Start time:<br>
        <input title="startDate" type="text"><br>

        End time:<br>
        <input title="endDate" type="text"><br>

        Tag:<br>
        <input title="tag" type="text"><br>

        Time zone:<br>
        <select title="timeZone">
            <option value="GMT +1:00">GMT +1:00</option>
            <option value="GMT +2:00">GMT +2:00</option>
        </select><br>

        Description:<br>
        <input title="description" type="text"><br>

        <input title="addEvent" type="submit" value="Add event">
        <input title="removeEvent" type="button" value="Remove">
        <br>
        <input title="clearEvents" type="button" value="Clear"><br><br>

        <select title="fileType">
            <option selected="true" style="display:none;">From file...</option>
            <option value="csv">*.csv</option>
            <option value="xml">*.xml</option>
        </select>
        <input title="importFromFile" type="button" value="Import">

        <select title="planUz">
            <option selected="true" style="display:none;">Plan UZ</option>
            <option value="23">23 Inf-SP</option>
            <option value="24">24 Inf-SP</option>
        </select>
        <input title="importFromPlanUz" type="button" value="Import"><br><br>

        <input title="generateICal" type="button" value="Generate iCal">
        <input title="generateCsv" type="button" value="Generate CSV">

    </form>
</body>
</html>