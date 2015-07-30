# denkmalnotlocated

Intention dieses Projektes ist es Denkmal-Datensätze, die über denkmalgeocoding nicht georefernzierbar waren entgegenzunehmen und für Dokumentationszwecke wiederzugeben. Dafür wird ein Denkmal-Datensatz in Form eines JSON-Strings per POST dem Service übergeben. 

## Schnittstellen

### /denkmalnotlocated/service

Dieser Endpunkt erlaubt es JSON-formatierte Datensätze von Denkmälern per POST zu übergeben.
Format:
<pre><code>
{
	"denkmalnummer":1,
	"untergruppe1":"",
	"untergruppe2":"0",
	"strasse":"Adolphstrasse",
	"nummer":"o.Nr.",
	"bezirk":1,
	"plz":50679,
	"ort":"Deutz",
	"unterSchutz":"01.07.1980",
	"baujahrZusatz":"",
	"baujahr":"1910",
	"kurzbezeichnung":"Allee",
	"feedsFlatstoreEntryId":1,
	"timestamp":1432648733,
	"feedsEntityId":1187
}
</pre></code>  



### /denkmalnotlocated/service/notlocated

Unter dem Endpunkt /denkmalnotlocated/service/notlocated werden alle hinterlegten Datensätze in Form eines JSON-String Arrays zurückgegeben.

### /denkmalnotlocated/service/notlocated?res

Eigentlich handelt es sich um ein dynamisches System. D.h. es müssen zunächst Daten übergeben
werden, bevor sie angezeigt werden können. Da ich die ermittelten Daten aber für die Darstellung benötige, ohne die Möglichkeit zu haben sie erneut zu ermitteln, werden die Ergebnisse in der Datei src/main/resources/denkmalnotlocated.json vorgehalten. Dieses Ergebnis ist abrufbar, mit dem Übergabeparameter "?res".

### /denkmalnotlocated

Unter dem Endpunkt /denkmalnotlocated wird eine html-Schnittstelle zur Verfügung gestellt, die alle enthaltenden Datensätze auflistet.

## Beispiel

Eine Beispielhaft Implementierung findet sich im Projekt denkmalinkoeln/DenkmalNotLocated.java.

## Test

Es ist möglich per curl und einer der im Bereich test hinterlegten Dateien den Service auszuprobieren:
<pre><code>
curl -H "Content-Type: applicacurl -H "Content-Type: application/json" --data @denkmal1.json http://localhost:8080/denkmalnotlocated/service
</code></pre>
Der Service wird mit allen bereits hinterlegten Denkmal-Datensätzen in Form eines JSON-String als Array antworten.