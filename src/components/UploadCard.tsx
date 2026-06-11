interface UploadCardProps {
  onFileSelect: (file: File | null) => void;
  onAnalyze: () => void;
}

function UploadCard({
  onFileSelect,
  onAnalyze,
}: UploadCardProps) {
  return (
    <div>
      <input
        type="file"
        accept="image/*"
        onChange={(e) =>
          onFileSelect(
            e.target.files
              ? e.target.files[0]
              : null
          )
        }
      />

      <br />
      <br />

      <button onClick={onAnalyze}>
        Analyze Issue
      </button>
    </div>
  );
}

export default UploadCard;