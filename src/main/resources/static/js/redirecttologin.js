(function() {
const idleDurationSecs = 1800000; // Time of seconds
const redirectUrl =ctx+'/logout';
let idleTimeout;
const resetIdleTimeout = function() {
if(idleTimeout) clearTimeout(idleTimeout);
idleTimeout = setTimeout(() => location.href = redirectUrl, idleDurationSecs * 1000);
};
resetIdleTimeout();
['click', 'touchstart', 'mousemove'].forEach(evt =>
document.addEventListener(evt, resetIdleTimeout, false)
);
})();
