interface ResultCardProps {
  issueType: string;
  severity: string;
  complaint: string;
}

function ResultCard({
  issueType,
  severity,
  complaint,
}: ResultCardProps) {
  return (
    <div
      style={{
        marginTop: "30px",
        background: "#1e293b",
        color: "white",
        padding: "25px",
        borderRadius: "12px",
        boxShadow: "0 0 15px rgba(0,0,0,0.3)",
      }}
    >
      <h2>Analysis Result</h2>

      <h3>Issue Type</h3>
      <p>{issueType}</p>

      <h3>Severity</h3>
      <p>{severity}</p>

      <h3>Generated Complaint</h3>
      <p>{complaint}</p>
    </div>
  );
}

export default ResultCard;