
function Navbar() {
  return (
    <nav
      style={{
        background: "#0f172a",
        color: "white",
        padding: "15px 30px",
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
      }}
    >
      <h2>UrbanEye AI</h2>

      <div>
        <span style={{ marginRight: "20px" }}>
          Smart Civic Reporting
        </span>
      </div>
    </nav>
  );
}

export default Navbar;
